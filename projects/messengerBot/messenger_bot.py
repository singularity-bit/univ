from fbchat import log, Client
from fbchat.models import *

client = Client("100008489650804", "Vasile.Grosu98")

#thread_id='100005919199300'
thread_type=ThreadType.USER

# print("Own id: {}".format(client.uid))



# client.send(Message(text="test msg"), thread_id=thread_id, thread_type=ThreadType.USER)

# #client.logout()

    
class EchoBot(Client):
    def onMessage(self, author_id, message_object, thread_id, thread_type, **kwargs):
        self.markAsDelivered(thread_id, message_object.uid)
        self.markAsRead(thread_id)

        log.info("{} from {} in {}".format(message_object, thread_id, thread_type.name))

        # If you're not the author, echo
        if message_object.text == "gg2":
            self.send(message_object, thread_id=thread_id, thread_type=thread_type)


clinet = EchoBot("100008489650804", "Vasile.Grosu98")
client.listen()
