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
    // returns the user agent of the request (specific browser)
    //res.send(req.get('user-agent'));

    // returns all the content types accepted by the request
    res.send(req.accepted);
    // return he most appropriate content type for the request
    // res.send(req.accepts(['html','text','json']));

    // charsets supported by the request
    // res.send(req.acceptedCharsets());
    // check if a char set is supported
    // res.send(req.acceptsCharset('utf-8') ? 'yes' : 'no');

    // languages supported by the request
    //res.send(req.acceptedLanguages());
    // check if a language is supported
    //res.send(req.acceptsLanguage('fr') ? 'yes' : 'no');

});

app.get('/name/:name?', function(req, res){
    // get param (denoted by :) from the url
    // res.send(req.params.name);

    // if the param is sufixed with ? it means is optional
    // we can use param method instead of the params attribute
    res.send(req.param('name', 'default value'));

    /* other attributes of request that might be useful
    * protocol
    * secure
    * ip
    * ips
    * auth
    * subdomains
    * path
    * host
    * fresh
    * stale
    * xhr
     */
 });

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});