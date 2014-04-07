var express = require('express'),
    http = require('http');

var app = express();

app.configure(function() {
    app.set('port', process.env.PORT || 3000);
    // This is what allows you to get stuff from the request body
    // by default express doesn't do this.
    app.use(express.bodyParser());
});

app.get('/', function(req, res){
    res.render('home.jade', { title: "Express with Jade and Nodemon!!!"} );
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});