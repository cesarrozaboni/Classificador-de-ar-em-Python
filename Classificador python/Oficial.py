from flask import Flask
from flask import request
from flask import jsonify

import pandas as pd
import seaborn as sns
from sklearn.preprocessing import StandardScaler

app = Flask(__name__)

@app.route('/api/v1/prediction/co', methods=['POST'])
def hello_world():

    request_data = request.json
    scalar = StandardScaler()
    request_data = scalar.fit_transform(request_data)
    request_data = pd.DataFrame(request_data)
    print(request_data['x1'])

    response = {
        "prediction": request_data['x1']
    }

    return jsonify(response)


app.run()