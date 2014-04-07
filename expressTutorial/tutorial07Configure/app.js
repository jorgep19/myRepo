var express = require('express'),
    http = require('http');

var app = express();

//app.configure is called with no 'envName' is ran for all environments
app.configure(function() {
    // This sets specific app configurations
    // sets the port
    app.set('port', process.env.PORT || 3000);
    // sets the location for for the views folder
    app.set('views', __dirname + '/views');
    // sets your view engine
    app.set('view engine', 'jade');
    // this is hand for production environments to speed up load time
    app.set('view cache', true);
    // this configurations that only take a boolean
    // can be set with app.enable or app.disable
    app.enable('view cache'); // so this is the same as app.set('view cache', true);
    // other app configurations are
    // app.enable('case sensitive route')
    // app.disable('strict routing') where the URL must match exactly (/ at the end counts)
    // you can also create your one configurations like
    // app.set('random Name', true);

    // This are the middle-ware
    // This are executed before we sent it to the routes
    // the order in the app.use statement does matter a lot
    app.use(express.bodyParser());
    // methodOverride allows you to let browsers use put and delete as follows
    app.use(express.methodOverride());


    // consider you want to track how many time s a file is downloaded you can do this by
    // you can do this by calling your router before you express the static public folder
    // and have a route doing logic for counting before the call gets redirected to the
    // static folder to do the download
    app.use(app.router)

    // this allows to expose the public folder for the browser to see images and
    // stylesheets etc
    app.use(express.static(__dirname + '/public' ) );

    // other fun middle-ware can be found at www.senchalabs.org/connect/
});

// starting your app as NODE_ENV=envName node app.js allows to set different
// configuration per environment
// app.cofigure takes ('env name', function() { all the settings code }
/*app.configure('production', function() {
});*/

app.get('/', function(req, res){
    // when the view file has no extension (.jade) i will default to the
    // view engine define in the app configuration.
    // However you can explicitly set the view file to another extension
    // if you have the package for that engine in your project.
    // like res.render('home.ejs', { title: "Express with EJS!!!"} );
    res.render('home', { title: "Express with Jade!!!"} );
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});