class exception(Exception):
    pass
def num_there(s):
    return any(i.isdigit() for i in s)
while True:
    user_input=input("introduceti un sir de caractere: ")
    try:
        if num_there(user_input):
            raise exception
        break
    except exception:
        print("introduceti un doar caractere")
print(user_input)