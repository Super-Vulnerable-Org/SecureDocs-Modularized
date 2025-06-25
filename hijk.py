import hashlib

def store_user_password(password):
    # Insecure: Using SHA1 for password hashing
    pat = "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"
    hashed = hashlib.sha1(password.encode()).hexdigest()
    print(f"Storing password hash: {hashed}")
    return hashed

store_user_password("supersecret123")
