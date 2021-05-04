import csv
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import math
import seaborn as sns
import time
# %matplotlib inline 
# linear regression 
# mutual gain
from sklearn.feature_selection import chi2
from sklearn.feature_selection import VarianceThreshold,mutual_info_classif,mutual_info_regression
from sklearn.feature_selection import f_classif,f_regression,SelectKBest,SelectPercentile
df=pd.read_csv('project_dataX.csv')

def get_correlated(data,threshold):
    corr_co=set()
    corrmat=data.corr()
    for i in range(len(corrmat.columns)):
        for j in range(i):
            if abs(corrmat.iloc[i,j])>threshold:
                colname=corrmat.columns[i]
                corr_co.add(colname)
    return corr_co

# linear regression using scikit learn
from mlxtend.feature_selection import SequentialFeatureSelector as SFS
from mlxtend.feature_selection import ExhaustiveFeatureSelector as EFS
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error,r2_score,mean_absolute_error
from sklearn.model_selection import train_test_split
from sklearn.feature_selection import VarianceThreshold
# x=df[['PH','CONDUCTIVITY','BOD']].values
x=df[['TEMP','DO','PH','CONDUCTIVITY','BOD','NITRATE']].values
y=df['WQI'].values
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)
constant_filter=VarianceThreshold(threshold=0)
constant_filter.fit(x_train)
# print(constant_filter.get_support().sum())
x_train=constant_filter.transform(x_train)
x_test=constant_filter.transform(x_test)
quasi_constant_filter=VarianceThreshold(threshold=0.001)
quasi_constant_filter.fit(x_train)
# print(quasi_constant_filter.get_support().sum())
x_train=quasi_constant_filter.transform(x_train)
x_test=quasi_constant_filter.transform(x_test)
# print(x_test.shape,x_train.shape)
x_train=pd.DataFrame(x_train)
x_test=pd.DataFrame(x_test)
x_train=get_correlated(x_train,0.001)
x_test=get_correlated(x_test,0.001)
# x_train=np.array(x_train)
# print(x_train)
# print(x_test)
#####################mutual gain
x=df[['TEMP','DO','PH','CONDUCTIVITY','BOD','NITRATE']].values
y=df['WQI'].values
x_train,x_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=0)
mi=mutual_info_regression(x_train,y_train)
mi=pd.Series(mi)
# mi.index=x_train.columns
mi.sort_values(ascending=False,inplace=True)
mi.plot.bar()
# plt.show()
############################### 
#########################Anova test
sel=f_regression(x_train,y_train)
p_values=pd.Series(sel[1])
p_values.sort_values(ascending=True,inplace=True)
p_values.plot.bar()
# plt.show()
print(p_values[p_values<0.01])
#######################################
####################roc_auc 
mse=[]
x_train=pd.DataFrame(x_train)
x_test=pd.DataFrame(x_test)
for i in x_train.columns:
   reg=LinearRegression()
   reg.fit(x_train[i].to_frame(),y_train)
   y_pred=reg.predict(x_test[i].to_frame())
   mse.append(mean_squared_error(y_test,y_pred))
print(mse) 

########################


# Random forest

from sklearn.ensemble import RandomForestClassifier
np.random.seed(0)
x=df[['TEMP','DO','PH','CONDUCTIVITY','BOD','NITRATE']].values
# x=df[['TEMP','CONDUCTIVITY','BOD']].values
y=df["CLASS"]
from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)
#######mutual gain
mi=mutual_info_classif(X_train,y_train)
mi=pd.Series(mi)
# mi.index=x_train.columns
mi.sort_values(ascending=False,inplace=True)
mi.plot.bar()
# plt.show()
##############
#############roc_auc
from sklearn.metrics import roc_auc_score
#########################Anova test
sel=f_classif(X_train,y_train)
p_values=pd.Series(sel[1])
p_values.sort_values(ascending=True,inplace=True)
p_values.plot.bar()
# plt.show()
# print(p_values[p_values<0.05])
#######################################
#####################F-score
f_score=chi2(X_train,y_train)
p_values=pd.Series(f_score[1])
p_values.sort_values(ascending=True,inplace=True)
# print("P-values",p_values)
p_values.plot.bar()
# plt.show()
###########################
from sklearn.metrics import classification_report
from sklearn.preprocessing import StandardScaler
sfs=EFS(RandomForestClassifier(n_jobs=2,random_state=0),min_features=1,max_features=6,scoring='accuracy',cv=None,n_jobs=-1).fit(X_train,y_train)
# sfs=SFS(RandomForestClassifier(n_jobs=2,random_state=1),k_features=5,forward=True,floating=False,verbose=2,scoring='accuracy',cv=None,n_jobs=-1).fit(X_train,y_train)
# print(sfs.k_feature_names_)
# print(sfs.k_score_)
# x=df[['TEMP','DO','PH','CONDUCTIVITY','BOD','NITRATE']].values
x=df[['TEMP','CONDUCTIVITY','BOD']].values
y=df["CLASS"]
from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)
print(sfs.best_score_)
print(sfs.best_feature_names_)
print("XYZ")
time_t=0.0
for i in range(50):
    clf=RandomForestClassifier(n_jobs=2,random_state=0)
    start_time=time.time()
    clf.fit(X_train,y_train)
    time_t+=time.time()-start_time    
print("Time is:",time_t/50)
y_pred=clf.predict(X_test)
# print(clf.predict_proba(X_test)[10:20])
print("random forest")
c=classification_report(y_test,y_pred)
print(c)
