import random
import pandas as pd
import csv
import math
import numpy as np
df=pd.read_csv('bristol_river1.csv')
df=df[['TEMP','PH','CONDUCTIVITY','DO','BOD']]
# print(df.head())
# print(df.count())
count=len(df)
def rm_null(x):
    sum=0.0
    for i in range(0,len(x)):
        # print(str(str(x[i]).replace('.', '', 1)))
        # if(str(x[i]).strip()!='NAN' and str(x[i]).strip()!=''):
        if(isinstance(x[i],int) or isinstance(x[i],float)):
            if(x[i] is np.nan):
                x[i]=0
            else:
                sum=float(sum)+float(x[i])
        else:
            if(str(x[i]).replace('.', '', 1).isdigit()):
                sum=float(sum)+float(x[i])
            else:
                x[i]=0
    max=0.0
    for i in range(0,len(x)):
        if(float(x[i])>max):
            max=float(x[i])
    mean=sum/count
    for i in range(0,len(x)):
        if(float(x[i])==0):
            x[i]=mean
    return x
def max(x):
    m=0.0
    for i in range(0,len(x)):
        if(float(x[i])>m):
            m=float(x[i])
    return m 

def min(x):
    m=max(x)
    for i in range(0,len(x)):
        if(float(x[i])<m):
            m=float(x[i])
    return m

def normalization(x):
    mini=min(x)
    maxi=max(x)
    dif=maxi-mini
    for i in range(0,len(x)):
        x[i]=(float(x[i])-mini)/dif
    return x
def add_wqi(x):
    for i in range(0,len(x)):
        x.PH[i]=100*((float(x.PH[i])-7.0)/1.5)
        x.CONDUCTIVITY[i]=(float(x.CONDUCTIVITY[i])/1000)*100
        x.DO[i]=((((float(x.DO[i]))*0.05)-14.6)/(-9.6))*100
        x.BOD[i]=(float(x.BOD[i])/5)*100
        # x.NITRATE[i]=(float(x.NITRATE[i])/50)*100
        x.WQI[i]=(float(x.PH[i])*0.11+float(x.DO[i])*0.17+float(x.BOD[i])*0.11+float(x.CONDUCTIVITY[i])*0.12)/0.51
    return x.WQI
def add_class(x):
    for i in range(0,len(x)):
        if(float(x.WQI[i])<=25):
            x.CLASS[i]=0
        elif(float(x.WQI[i])>25 and float(x.WQI[i]<=50)):
            x.CLASS[i]=1
        elif(float(x.WQI[i])>50 and float(x.WQI[i])<=75):
            x.CLASS[i]=2
        elif(float(x.WQI[i])>75 and float(x.WQI[i])<=90):
            x.CLASS[i]=3
        elif(float(x.WQI[i])>90 and float(x.WQI[i])<=100):
            x.CLASS[i]=4
        else:
            x.CLASS[i]=5
    return x
'''
for i in range(4370,9360):
    df.TEMP[i]=random.randrange(26,31,1)
    df.DO[i]=random.randrange(50,150,5)
    df.CONDUCTIVITY[i]=random.randrange(500,1500,10)
    df.BOD[i]=random.randrange(1,10,1)
    df.PH[i]=random.uniform(6.5,8.5)
# df.append(x,ignore_index=True)

'''
# print(float(df.TEMP[4]))
# print(df.head())
df.TEMP=rm_null(df.TEMP)
df.PH=rm_null(df.PH)
df.CONDUCTIVITY=rm_null(df.CONDUCTIVITY)
df.DO=rm_null(df.DO)
df.BOD=rm_null(df.BOD)
df['WQI']=df.PH
df.WQI=add_wqi(df)
df.TEMP=normalization(df.TEMP)
df.CONDUCTIVITY=normalization(df.CONDUCTIVITY)
df.PH=normalization(df.PH)
df.BOD=normalization(df.BOD)
df.DO=normalization(df.DO)
df['CLASS']=df.PH
df=add_class(df)
df.to_csv('bristol_river2.csv')
