# Client Program:
import socket
from datetime import datetime, timedelta


def start_client():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect(("127.0.0.1", 5000))
    # send current time
    local_time = datetime.now()
    client.send(str(local_time).encode())
    # receive adjustment
    diff = float(client.recv(1024).decode())
    new_time = local_time + timedelta(seconds=diff)
    print("Synchronized time at the client is :", new_time)
    client.close()


if __name__ == "__main__":
    start_client()
