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

var users = ['joe', 'jeff', 'sally', 'kim', 'john', 'jane'];
// this is like middleware for the 'from' waiting route
app.param('from', function( req, res, next, from) {
    req.from = parseInt( from, 10);

    // this moves to the next middleware
    next();

});

// this is like middleware for the 'to' waiting route
app.param('to', function( req, res, next, to) {
    req.to = parseInt( to, 10);

    // this moves to the next middleware
    next();

});

app.get('/users/:from-:to', function(req, res ) {

    res.json( users.slice( req.from, req.to +1 ) );
});

var count = 0;
// you can intercept a could before it goes to the public directory ust make sure you call next() to go back to
// the middleware stack
app.get('/hello.txt', function(req, res, next) {

    count++;
    next();
});

//
app.get('/count', function(req, res) {
    res.json(count);
})


function loadUser (req, res, next) {
    req.user = users[ parseInt( req.params.userId, 10 ) ];
    next();
}
// you can pass function to make then middleware specific to this route
app.get('/users/:userId', loadUser, function(req, res ) {

    // get user
    // res.json( user);
    res.json( req.user );
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});