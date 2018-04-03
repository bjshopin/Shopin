#include<cstdio>
 #include<cmath>
 #include<algorithm>
 #include<cstring>
 #include<map>
 #include<set>
 #include<queue>
 #include<vector> 
 #define PI acos(-1)
 #define MOD 1000000007 
 using namespace std;
 //typedef  __int64 L;
 typedef long long LL;
 LL n,sum;
 LL arr[100];
 int main() 
 {
 	int t;
  scanf("%d",&t);
   arr[1]=0,arr[2]=2,arr[3]=8;
  while(t--)
  {
  	sum=0;
  	scanf("%lld",&n);
  	if(n==10)sum=10;
  	else
 	 {
  	  for(int i=2;arr[i]<=n;i++)
  	  {
	   arr[i+1]=4*arr[i]+arr[i-1];
	   sum+=arr[i];	
      }
    } 
	printf("%lld\n",sum);  
 }
 } 