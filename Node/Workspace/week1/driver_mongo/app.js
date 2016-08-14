var mongoClient = requiere('mongodb').MongoClient;
var assert = requiere('assert');

var url = 'mongodb://localhost:27017/video';

mongoClient.connect(url, function (err, db){
	assert.equal(null,err);
	console.log('Successfully connected to server');
	db.collection('movies').find({}).toArray(function(err,doc){
		docs.forEach(function(doc){
			console.log(doc.tittle);
		});
		db.close();
	});
	console.log('called find()');
});