var express = require('express'),
    http = require('http');

var app = express();

app.configure(function() {
    app.set('port', process.env.PORT || 3000);
    app.set('views', __dirname + '/views');
    app.set('view engine', 'jade');

    app.use(express.bodyParser());
    app.use(express.methodOverride());
    app.use(app.router);
    app.use(express.static(__dirname + '/public' ) );
});

app.get('/', function(req, res){
    // you can send the http status code as the first parameter of the res.send()
    // res.send(404, 'not found');

    // you can use this to sen a json directly
    // var myObject = { stuff: 'value'};
    // res.json(myObject);

    res.type('image/png)')
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});