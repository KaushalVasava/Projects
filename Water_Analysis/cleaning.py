import pandas as pd
import csv
import math
import numpy as np
df=pd.read_csv('bristol_river.csv')
df=df.drop(['SAMPLE','E-Coli','Nitrite','Nitrate','TOTAL_COLI','Weather','Location','SITE','SALINITY','PHOSPHATE','COD','FEACEL','AMONIAUM'],axis=1)
df=df.drop(df.index[[0,1,2,3]])
# print(df.head())
# print(df.count())
count=4368
def rm_null(x):
    sum=0.0
    for i in range(4,len(x)):
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
    for i in range(4,len(x)):
        if(float(x[i])>max):
            max=float(x[i])
    mean=sum/count
    for i in range(4,len(x)):
        if(float(x[i])==0):
            x[i]=mean
    return x
def max(x):
    m=0.0
    for i in range(4,len(x)):
        if(float(x[i])>m):
            m=float(x[i])
    return m 

def min(x):
    m=max(x)
    for i in range(4,len(x)):
        if(float(x[i])<m):
            m=float(x[i])
    return m

def normalization(x):
    mini=min(x)
    maxi=max(x)
    dif=maxi-mini
    for i in range(4,len(x)):
        x[i]=(float(x[i])-mini)/dif
    return x
def add_wqi(x):
    for i in range(4,len(x)):
        x.PH[i]=100*((float(x.PH[i])-7.0)/1.5)
        x.Conductivity[i]=(float(x.Conductivity[i])/250)*100
        x.DO[i]=(((float(x.DO[i])*5)/100-14.6)/(-9.6))*100
        x.BOD[i]=(float(x.BOD[i])/5)*100
        # x.NITRATE[i]=(float(x.NITRATE[i])/50)*100
        x.WQI[i]=(float(x.PH[i])*0.21+float(x.DO[i])*0.37+float(x.BOD[i])*0.37+float(x.Conductivity[i])*0.37)/1.32
    return x.WQI
def add_class(x):
    for i in range(4,len(x)):
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
x=df.TEMP
# print(float(df.TEMP[4]))
# print(df.head())
df.TEMP=rm_null(df.TEMP)
df.PH=rm_null(df.PH)
df.Conductivity=rm_null(df.Conductivity)
df.DO=rm_null(df.DO)
df.BOD=rm_null(df.BOD)
df['WQI']=df.PH
df.WQI=add_wqi(df)
df.TEMP=normalization(df.TEMP)
df.Conductivity=normalization(df.Conductivity)
df.PH=normalization(df.PH)
df.BOD=normalization(df.BOD)
df.DO=normalization(df.DO)
df['CLASS']=df.PH
df=add_class(df)
df.to_csv('bristol_river1.csv')
