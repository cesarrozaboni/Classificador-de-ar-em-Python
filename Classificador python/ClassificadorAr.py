import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn import svm
import numpy as np


def predict(co, pt08co, nmhc, pt08nmhc, nox, pt08nox, no2, pt08o3, t, rh, ah):
    x_pred = np.array([co, pt08co, nmhc, pt08nmhc, nox, pt08nox, no2, pt08o3, t, rh, ah])
    x_pred = np.expand_dims(x_pred, axis=0)

    air_data = pd.read_excel('AirQualityUCI.xlsx')

    air_data.dropna(axis=0, how='all')

    features = air_data

    features = features.drop('Date', axis=1)
    features = features.drop('Time', axis=1)
    features = features.drop('C6H6(GT)', axis=1)
    features = features.drop('PT08.S4(NO2)', axis=1)

    air_data.loc[air_data['C6H6(GT)'] <= 5, 'C6H6(GT)'] = 0
    air_data.loc[(air_data['C6H6(GT)'] > 5) & (air_data['C6H6(GT)'] <= 10), 'C6H6(GT)'] = 1
    air_data.loc[(air_data['C6H6(GT)'] > 10) & (air_data['C6H6(GT)'] <= 15), 'C6H6(GT)'] = 2
    air_data.loc[(air_data['C6H6(GT)'] > 15) & (air_data['C6H6(GT)'] <= 20), 'C6H6(GT)'] = 3
    air_data.loc[air_data['C6H6(GT)'] > 20, 'C6H6(GT)'] = 4

    labels = air_data['C6H6(GT)'].values

    features = features.values

    X_train, X_test, y_train, y_test = train_test_split(features, labels, test_size=0.3)

    support_regressor = svm.SVC(kernel='linear', C=1000)
    support_regressor.fit(X_train, y_train)

    prediction = support_regressor.predict(x_pred)

    return prediction


if __name__ == "__main__":
    predict()