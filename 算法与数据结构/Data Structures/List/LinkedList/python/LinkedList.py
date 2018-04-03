from Node import *;


class LinkedList:
    def __init__(self):
        self.head = None

    def push(self,new_data):

        new_data=Node(new_data)

        new_data.next=self.head

        self.head=new_data

    def printList(self):

        temp=self.head
        while(temp):
            print temp.data
            temp=temp.next


if __name__ == '__main__':

    llist = LinkedList()

    llist.push(6)

    llist.push(7)

    llist.printList()
