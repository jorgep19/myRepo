var express = require('express'),
    http = require('http');

var app = express();

app.configure(function() {
    app.set('port', process.env.PORT || 3000);
    app.set('views', __dirname + '/views');
    app.set('view engine', 'jade');

    // this middleware is require for cookies
    app.use(express.cookieParser());

    // this middleware is require for sessions but you also need the cookies
    // also the param is hashed so you don't need to worry to much about it
    app.use(express.session( { secret: 'this is a secret' } ) );

    app.use(app.router);
    app.use(express.static(__dirname + '/public' ) );
});

// this is the signature for the res.cookie, you can see more about the options json (last param) at express docs
// res.cookie( name, value, { expires: new Date() + 900000, maxAge: 90000 });

app.get('/name/:name', function(req, res) {

    // add stuff to the session
    req.session.name = req.params.name;
    res.send('<p> To see the session in action, <a href="/name">Go here</a></p>');

//    // you can see the cookie and then imminently send the response.
//    res.cookie('name', req.params.name)
//        .send('<p> To see the cookie in action, <a href="/name">Go here</a></p>');
});

app.get('/name', function(req, res){

    // retrieve stuff from the session
    res.send( req.session.name );

    // you can retrieve the cookie by getting it from req.cookies.youCookieName
    // res.send( req.cookies.name );

    // you can also do
    // res.clearCookie('name').send(req.cookies.name);
    // which would would clear the cookie with the name passed int
});

// diff between cookies and session is that cookies are on the client and sessions are on the server


http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});