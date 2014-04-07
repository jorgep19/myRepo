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
    var myObject = { stuff: 'value'};
    res.json(myObject);

    // specify the type of the response
    // res.type('image/png)').send('This is picture');

    // setup frst then get the appropiate format for the accepted response
//    res.format({
//        html: function() { res. send("<h> Body </h>"); },       // usually default
//        json: function() { res.json({ message: 'body' } ) },    // curl localhost:3000 -H "accept: application/json"
//        text: function() { res.send('body') }                   // curl localhost:3000 -H "accept: text/plain"
//    });
});

//redirecting calls
app.get('/home', function(req, res){
    // also you can setup the status of the response here
    // 302 means redireccted temperoraly
    res.status(302).redirect('/');

    // to check you can set the headers using
    // res.set / res,header

    // Addition methos to checkout
    // send file
    // download
    // attachment
    // links
    // clearCookie
    // cookies
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});