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
# constant_filter=VarianceThreshold(threshold=0)
# # constant_filter.fit(x_train)
# quasi_constant_filter=VarianceThreshold(threshold=0.001)
# quasi_constant_filter.fit(x_train)
# print(quasi_constant_filter.get_support().sum())
# x_train=quasi_constant_filter.transform(x_train)
# x_test=quasi_constant_filter.transform(x_test)
#  print(x_test.shape,x_train.shape)
# x_train=pd.DataFrame(x_train)
# x_test=pd.DataFrame(x_test)
# x_train=get_correlated(x_train,0.)
# # x_train=np.array(x_train)
# print(x_train)
# #####################mutual gain
# mi=mutual_info_regression(x_train,y_train)
# mi=pd.Series(mi)
# # mi.index=x_train.columns
# mi.sort_values(ascending=False,inplace=True)
# mi.plot.bar()
# plt.show()
# ###############################
#####################roc_auc 
# mse=[]
# x_train=pd.DataFrame(x_train)
# x_test=pd.DataFrame(x_test)
# for i in x_train.columns:
#    reg=LinearRegression()
#    reg.fit(x_train[i].to_frame(),y_train)
#    y_pred=reg.predict(x_test[i].to_frame())
#    mse.append(mean_squared_error(y_test,y_pred))
# print(mse) 
#########################
'''
reg =LinearRegression()
start_time=time.time()
reg.fit(x_train,y_train)
print(time.time()-start_time)
y_pred=reg.predict(x_test)
print("linear model:",r2_score(y_test,y_pred))
print(mean_squared_error(y_test,y_pred))
print(mean_absolute_error(y_test,y_pred))
# print(np.std(y))
'''
'''
# polynomial regression
from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)

from sklearn.linear_model import LinearRegression
lin=LinearRegression()
lin.fit(X_train,y_train)
y_pred=lin.predict(X_test)
from sklearn.preprocessing import PolynomialFeatures
# from sklearn.linear_model import LinearRegression

poly=PolynomialFeatures(degree=2)
x_poly=poly.fit_transform(x_train)
poly.fit(x_poly,y_train)

lin1=LinearRegression()
lin1.fit(x_poly,y_train)

y1_pred=lin1.predict(poly.fit_transform(x_test))
print("Polynomial regression")
print(r2_score(y_test,y1_pred))
print(mean_squared_error(y_test,y1_pred))
print(mean_absolute_error(y_test,y1_pred))
'''
'''
# logistic regression
# x=df[['CONDUCTIVITY','NITRATE']].values
x=df[['TEMP','DO','PH','CONDUCTIVITY','BOD','NITRATE']].values
y=df["CLASS"]
from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)

quasi_constant_filter=VarianceThreshold(threshold=0.001)
quasi_constant_filter.fit(X_train)
X_train=quasi_constant_filter.transform(X_train)
X_test=quasi_constant_filter.transform(X_test)
from sklearn.linear_model import LogisticRegression
 
logmodel=LogisticRegression()
logmodel.fit(X_train,y_train)
pred=logmodel.predict(X_test)

from sklearn.metrics import classification_report
print("Logistic regression")
c=classification_report(y_test,pred)
print(c)
'''
# Random forest

from sklearn.ensemble import RandomForestClassifier
np.random.seed(0)
x=df[['TEMP','DO','PH','CONDUCTIVITY','BOD','NITRATE']].values
# x=df[['TEMP','CONDUCTIVITY','BOD']].values
y=df["CLASS"]
from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)
# df=pd.read_csv('water_dataX.csv')
#######mutual gain
# mi=mutual_info_classif(X_train,y_train)
# mi=pd.Series(mi)
# # mi.index=x_train.columns
# mi.sort_values(ascending=False,inplace=True)
# mi.plot.bar()
# plt.show()
##############
#############roc_auc
from sklearn.metrics import roc_auc_score
#########################Anova test
# sel=f_classif(X_train,y_train)
# p_values=pd.Series(sel[1])
# p_values.sort_values(ascending=True,inplace=True)
# p_values.plot.bar()
# plt.show()
# print(p_values[p_values<0.05])
#######################################
 
from sklearn.metrics import classification_report
from sklearn.preprocessing import StandardScaler
sfs=EFS(RandomForestClassifier(n_jobs=2,random_state=0),min_features=1,max_features=6,scoring='accuracy',cv=None,n_jobs=-1).fit(X_train,y_train)
# # print(sfs.k_feature_names_)
print(sfs.best_score_)
print(sfs.best_feature_names_)
# print("XYZ")
clf=RandomForestClassifier(n_jobs=2,random_state=0)
clf.fit(X_train,y_train)
y_pred=clf.predict(X_test)
# print(clf.predict_proba(X_test)[10:20])
print("random forest")
c=classification_report(y_test,y_pred)
print(c)
'''
# decision tree
from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)

from sklearn.tree import DecisionTreeClassifier

clf_gini=DecisionTreeClassifier(criterion="gini",random_state=100,max_depth=3,min_samples_leaf=5)
clf_gini.fit(X_train,y_train)
clf_entropy=DecisionTreeClassifier(criterion="entropy",random_state=100,max_depth=3,min_samples_leaf=5)
clf_entropy.fit(X_train,y_train)
y_pred_gini=clf_gini.predict(X_test)
y_pred_entropy=clf_entropy.predict(X_test)


from sklearn.metrics import accuracy_score 
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix 
print("decision tree")
print("confusion metrix: ",confusion_matrix(y_test,y_pred_gini))
print("accuracy_score: ",accuracy_score(y_test,y_pred_gini))
print("classification_report: ",classification_report(y_test,y_pred_gini))
print("confusion metrix: ",confusion_matrix(y_test,y_pred_entropy))
print("accuracy_score: ",accuracy_score(y_test,y_pred_entropy))
print("classification_report: ",classification_report(y_test,y_pred_entropy))

# svm

from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)

from sklearn import svm
# from sklearn  import metrics
cls=svm.SVC(kernel="linear")
cls.fit(X_train,y_train)
y_pred=cls.predict(X_test)
 
from sklearn.metrics import accuracy_score 
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix 
print("SVM")
print("confusion metrix: ",confusion_matrix(y_test,y_pred))
print("accuracy_score: ",accuracy_score(y_test,y_pred)) 
print("classification_report: ",classification_report(y_test,y_pred))
# print(len(y_test))

# naive bayes

from sklearn.model_selection import train_test_split
X_train,X_test,y_train,y_test=train_test_split(x,y,test_size=0.2,random_state=1)


from sklearn.naive_bayes import GaussianNB
# from sklearn  import metrics
gnb=GaussianNB()
gnb.fit(X_train,y_train)
y_pred=gnb.predict(X_test)
 
from sklearn.metrics import accuracy_score 
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix 
print("NB")
print("confusion metrix: ",confusion_matrix(y_test,y_pred))
print("accuracy_score: ",accuracy_score(y_test,y_pred)) 
print("classification_report: ",classification_report(y_test,y_pred))

#  KNN
from sklearn.neighbors import KNeighborsClassifier 
K = [] 
training = [] 
test = [] 
scores = {} 
  
for k in range(2, 5): 
    clf = KNeighborsClassifier(n_neighbors = k) 
    clf.fit(x_train, y_train) 
  
    training_score = clf.score(x_train, y_train) 
    test_score = clf.score(x_test, y_test) 
    K.append(k) 
  
    training.append(training_score) 
    test.append(test_score) 
    scores[k] = [training_score, test_score] 
for keys, values in scores.items(): 
    print(keys, ':', values) 
'''