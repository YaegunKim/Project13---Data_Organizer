from flask import Flask, request, render_template, jsonify
import csv
import mysql.connector
from io import StringIO

app = Flask(__name__)

# Database connection parameters
db_config = {
    'database': 'your_dbname',
    'user': 'your_username',
    'password': 'your_password',
    'host': 'your_host'
}

# Route for rendering the HTML page
@app.route('/')
def index():
    return render_template('index.html')

# Route for handling the CSV upload
@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return jsonify(error="No file part"), 400
    file = request.files['file']
    if file.filename == '':
        return jsonify(error="No selected file"), 400
    # rest of your code


    stream = StringIO(file.stream.read().decode("UTF8"), newline=None)
    csv_input = csv.reader(stream)
    next(csv_input, None)  # Skip the header row
    
    conn = mysql.connector.connect(**db_config)
    cur = conn.cursor()

    for row in csv_input:
        cur.execute('INSERT INTO students (name, score) VALUES (%s, %s)', row)
    
    conn.commit()
    cur.close()
    conn.close()

    return 'Successfully uploaded and inserted data'

# Route for getting the data from the database
@app.route('/data', methods=['GET'])
def get_data():
    conn = mysql.connector.connect(**db_config)
    cur = conn.cursor()
    cur.execute('SELECT * FROM students')
    students = cur.fetchall()
    cur.close()
    conn.close()

    return jsonify(students)

if __name__ == '__main__':
    app.run(debug=True)