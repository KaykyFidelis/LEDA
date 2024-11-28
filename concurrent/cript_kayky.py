import os
import sys
import concurrent.futures

def read_file(directory_path, file_name):
    ''' A thread é criada antes da leitura do arquivo para deixar o processo de leitura mais rápido.
        Sendo assim, cada thread se responsabiliza por cuidar de um arquivo e processa a leitura e só então a escrita'''

    file_path = os.path.join(directory_path, file_name)
    if os.path.isfile(file_path):
        with open(file_path, 'r') as file:
            passwords = [line.strip() for line in file.readlines()]
    process_file_and_write(file_path, file_path, passwords)

def read_passwords_from_dir(directory: str) -> dict:
    try:
        with concurrent.futures.ThreadPoolExecutor(max_workers=16) as executor:
            futures = {executor.submit(read_file, directory, file_name): file_name for file_name in os.listdir(directory)}
            for future in concurrent.futures.as_completed(futures):
                future.result()
    except FileNotFoundError:
        print(f"Erro: Diretório não encontrado no caminho {directory}.")
    except Exception as e:
        print(f"Ocorreu um erro: {e}")

def rot13_obfuscation(password: str) -> str:
    return "".join(
        chr((ord(char) - 65 + 13) % 26 + 65) if char.isupper() else
        chr((ord(char) - 97 + 13) % 26 + 97) if char.islower() else char
        for char in password
    )

def process_file_and_write(file_name: str, file_path: str, passwords: list):
    """Process and overwrite the file with ROT13-obfuscated passwords."""
    obfuscated_passwords = [rot13_obfuscation(password) for password in passwords]

    try:
        with open(file_path, 'w') as file:
            file.write("\n".join(obfuscated_passwords) + "\n")
            print(f"Processed and updated file: {file_name}")
    except Exception as e:
        print(f"Erro ao escrever no arquivo {file_path}: {e}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Uso: python script.py <caminho_do_diretorio>")
        sys.exit(1)

    directory_path = sys.argv[1]

    read_passwords_from_dir(directory_path)