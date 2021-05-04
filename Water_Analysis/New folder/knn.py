import pandas as pd
import csv
import math
import numpy as np
from sklearn.model_selection import train_test_split
df=pd.read_csv('project_dataX.csv')
x=df[['TEMP','DO','PH','CONDUCTIVITY','BOD','NITRATE']].values
y=df['CLASS'].values
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)
# print(x_train[0,:])
dist=x_train[:,0]
dist1=x_test[:,0]
def dist(k):
    for i in range(0,len(x_test)):
        for j in range(0,len(x_train)):
            dist[j]=math.sqrt((float(x_train[j,1])-float(x_test[j,1]))**2+(float(x_train[j,2])-float(x_test[j,2]))**2+(float(x_train[j,3])-float(x_test[j,3]))**2+(float(x_train[j,4])-float(x_test[j,4]))**2+(float(x_train[j,5])-float(x_test[j,5]))**2)
