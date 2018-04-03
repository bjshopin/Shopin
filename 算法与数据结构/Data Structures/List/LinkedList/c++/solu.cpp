#include<bits\stdc++.h>
using namespace std;

typedef long long ll;

struct Node
{
    int val;
    Node* next;
    Node(int val){
        this->val=val;
        this->next=NULL;
    }
};
inline void printList(Node* head){

    while(head!=NULL){
        printf("%d-->", head->val);
        head=head->next;
    }
    printf("NULL\n");
}

int main(int argc, char const *argv[])
{
     Node* head=(Node*)malloc(sizeof(Node));
     Node* second=(Node*)malloc(sizeof(Node));
     Node* third=(Node*)malloc(sizeof(Node));
     
     head->val=1;
     head->next=second;
     second->val=2;
     second->next=third;
     third->val=3;
     printList(head);
}
