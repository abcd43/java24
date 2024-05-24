#include<iostream>
using namespace std;
class Weather
{
private:
int day;
float htemp,ltemp,rainAmount,snowAmount;
public:
Weather()
{
day=0;
htemp=999;
ltemp=-999;
rainAmount=0;
snowAmount=0;
}
Weather(int a,float b,float c,float d,float e)
{
day=a;
htemp=b;
ltemp=c;
rainAmount=d;
snowAmount=e;
}
Weather(Weather &w)
{
day=w.day;
htemp=w.htemp;
ltemp=w.ltemp;
rainAmount=w.rainAmount;
snowAmount=w.snowAmount;
}
void accept()
{
cout<<"\nEnter the day of month:";
cin>>day;
cout<<"Enter high temperature:";
cin>>htemp;
cout<<"Enter low temperature:";

cin>>ltemp;
cout<<"Enter the rain of day:";
cin>>rainAmount;
cout<<"Enter the snow of day:";
cin>>snowAmount;
}
void display()
{
cout<<"\n"<<day<<"\t"<<htemp<<"\t"<<ltemp<<"\t"<<rainAmount<<"\t"<<snowAmount;
cout<<"\n-------------------------------------------------\n";
}
void average(Weather w4[31],int n)
{
float sumht=0.0,sumlt=0.0,sumrain=0.0,sumsnow=0.0;
float alt,aht,arain,asnow;
for(int i=0;i<n;i++)
{
sumht=sumht+w4[i].htemp;
sumlt=sumlt+w4[i].ltemp;
sumrain=sumrain+w4[i].rainAmount;
sumsnow=sumsnow+w4[i].snowAmount;
}
alt=sumlt/n;
aht=sumht/n;
arain=sumrain/n;
asnow=sumsnow/n;
cout<<"\nAverage of:"<<arain;
cout<<"\nAverage of Snow:"<<asnow;
cout<<"\nAverage of High temp:"<<aht;
cout<<"\nAverage of Low temp:"<<alt;
}
};
int main()
{
int ch,n=0,i;
Weather w1[31];
Weather w2;
do{

cout<<"\n--------Weather Report------";
 cout<<"\n1.Accept"<<"\n2.Display"<<"\n3.Average"<<"\n4.EXIT\n";
cout<<"\nEnter choice:";
 cin>>ch;
switch(ch)
{
 case 1:
 cout<<"\nEnter the number of days: \n";

 cin>>n;

 for(i=0;i<n;i++){

 cout<<"Enter the values for day "<<i+1;
 cout<<"\n";
 w1[i].accept();

 }

 break;
 case 2:
 cout<<"\nDay"<<"\t"<<"Htem"<<"\t"<<"Ltem"<<"\t"<<"Rain"<<"\t"<<"Snow";
 cout<<"\n===============================================\n";
 for(i=0;i<n;i++)
 {

 w1[i].display();

 }
 break;
 case 3:
 w2.average(w1,n);
 break;

case 4:
	cout<<"\nEXIT";
	exit(0);
	break;
}
}
while(ch!=4);
 return 0;
}
