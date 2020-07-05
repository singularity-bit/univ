from fbchat import Client
from fbchat.models import *

client = Client("100008489650804", "Vasile.Grosu98")

thread_id='100005919199300'
thread_type=ThreadType.USER

# print("Own id: {}".format(client.uid))



# client.send(Message(text="test msg"), thread_id=thread_id, thread_type=ThreadType.USER)

# #client.logout()

    
class CustomClient(Client):
    
    def onMessage(self, mid, author_id, message_object, thread_id, thread_type, ts, metadata, msg, **kwargs):
        
        if "te iubesc" in message_object:
            client.send(Message(text="si eu!!!!"), thread_id=thread_id, thread_type=ThreadType.USER)
        pass

client = CustomClient('100008489650804', 'Vasile.Grosu98')
