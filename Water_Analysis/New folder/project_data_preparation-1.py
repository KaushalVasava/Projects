import pandas as pd
import csv
import math
import numpy as np

df=pd.read_csv('water_datX.csv')
df=df.drop(['STATION','LOCATION','STATE','YEAR','TOTAL_COLI'],axis=1)
df=df.drop(df.tail(101).index)
count=1890
def rm_null(x):
    sum=0.0
    for i in range(0,len(df)):
        if(str(x[i]).strip()!='NAN' and str(x[i]).strip()!=''):
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
        x.CONDUCTIVITY[i]=(float(x.CONDUCTIVITY[i])/250)*100
        x.DO[i]=((float(x.DO[i])-14.6)/(5-14.6))*100
        x.BOD[i]=(float(x.BOD[i])/5)*100
        x.NITRATE[i]=(float(x.NITRATE[i])/50)*100
        x.WQI[i]=(float(x.PH[i])*0.21+float(x.DO[i])*0.37+float(x.BOD[i])*0.37+float(x.CONDUCTIVITY[i])*0.37+float(x.NITRATE[i])*0.04)/1.36
        # x.WQI[i]=(float(x.PH[i])*0.21+float(x.DO[i])*0.0185+float(x.BOD[i])*0.37+float(x.CONDUCTIVITY[i])*0.37)/1.32
    return x.WQI
def add_class(x):
    for i in range(0,len(x)):
        if(x.WQI[i]<=25):
            x.CLASS[i]=0
        elif(x.WQI[i]>25 and x.WQI[i]<=50):
            x.CLASS[i]=1
        elif(x.WQI[i]>50 and x.WQI[i]<=75):
            x.CLASS[i]=2
        elif(x.WQI[i]>75 and x.WQI[i]<=100):
            x.CLASS[i]=3
        else:
            x.CLASS[i]=4
    return x
df.TEMP=rm_null(df.TEMP)
df.PH=rm_null(df.PH)
df.DO=rm_null(df.DO)
df.BOD=rm_null(df.BOD)
df.CONDUCTIVITY=rm_null(df.CONDUCTIVITY)
df.FECAL_COLI=rm_null(df.FECAL_COLI)
df.NITRATE=rm_null(df.NITRATE)
df['WQI']=df.PH
df.WQI=add_wqi(df)
df.TEMP=normalization(df.TEMP)
df.PH=normalization(df.PH)
df.DO=normalization(df.DO)
df.BOD=normalization(df.BOD)
df.FECAL_COLI=normalization(df.CONDUCTIVITY)
df.CONDUCTIVITY=normalization(df.FECAL_COLI)
df.NITRATE=normalization(df.NITRATE)
df['CLASS']=df.PH
df=add_class(df)
print(df.CLASS.count())
# print(min(df.NITRATE))
df.to_csv('project_Bristol.csv')