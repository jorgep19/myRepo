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
    //res.send("go to /tags for usage and to /advance for fancy stuff")
    res.render('home');
});

app.get('/fancy', function(req, res){
    //res.send("go to /tags for usage and to /advance for fancy stuff")
    res.render('advance', { someText: 'paramater passed in' });
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});