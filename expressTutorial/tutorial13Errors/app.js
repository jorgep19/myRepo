var express = require('express'),
    http = require('http');

var app = express();

app.configure(function() {
    app.set('port', process.env.PORT || 3000);
    app.set('views', __dirname + '/views');
    app.set('view engine', 'jade');

    app.use(app.router);
    app.use(express.static(__dirname + '/public' ) );

    // this will be the 404 middle ware because is at the end when nothing matches the url
    app.use(function (req, res) {
        res.send(404, 'nope.... 404')
    });

    // this will receive the control as soon as the error is passed to next()
    app.use(function (err, req, res, next ){

        res.status(err.status || 404);
        res.json(err.message);
    });
});

// this is a nice approach to check a param and throw an error if needed
// ALWAY TRY TO KEEP ROUTE FUNCTIONS THIN
app.param('username', function(req, res, next, username){
    if(username !== 'andrew' ) {
        req.username = username;
        next()
    } else {
        next(new Error('no user found!'))
    }
})

app.get('/index', function(req, res) {
    res.send('index');
});

app.get('/users/:username', function(req, res, next ) {
    res.send(req.username + "'s profile");
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});