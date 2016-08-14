var express = require('express');
var app = express();
var engines = require('consolidate')

app.engine('html', engines.nunjucks);
app.set('view engine', 'html');
app.set('views',__dirname + '/views');

app.get('/', function(req, resp){
	resp.render('hello',{'name':'Templates'});
});

app.use(function(req,resp){
	resp.sendStatus(404);
});

var server = app.listen(3000, function () {
	var port = server.address().port;
  console.log('Example app listening on port 3000!');
});
