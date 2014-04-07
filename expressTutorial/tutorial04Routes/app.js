var express = require('express'),
    http = require('http');

var app = express();

app.configure(function() {
    app.set('port', process.env.PORT || 3000);
    // This is what allows you to get stuff from the request body
    // by default express doesn't do this.
    app.use(express.bodyParser());
});

// Database maps to HTTP requests
// Create           POST
// Read             GET
// Update           PUT
// Delete           DELETE

// all route call get the request and response objects
// Getting the call form a URL (root in this case)
app.get('/', function(req, res){
   res.send("Hello, Express!");
});


// Returning HTML using send (instead of just plain text
app.get('/hi',function(req, res) { // reg Expression representation /\/hi(\/)?/, function(req, res){
   var message = '<h1>Hello, Express</h1>' +
                 '<p> Welcome to \'Building Web App in Node.js with Express'+
                 '<p>You\'ll love Express because it\'s' +
                 '<ul>' +
                     '<li>fast</li>' +
                     '<li>fun</li>' +
                     '<li>flexible</li>' +
                 '</ul>';

    res.send(message);
});

// Getting parameters from the URL
/*app.get('/users/:userId', function(req, res) {
   res.send('<h1>Hello, User ' + req.params.userId + '</h1>');
});*/

// Getting post requests and getting data from the request body
app.post('/users', function(req, res){
    res.send('Creating a new user with the name ' + req.body.username );
});

// other methods
// app.put for example you could go to '/users/:userId' to update the user data
// app.delete for example you could go to '/users/:userId' to delete the user data


// you could also use regular expression to catch routes
app.get(/\/users\/(\d*)\/?(edit)?/, function(req, res) {
    // \/users\/ looks for /users/ followed by
    // (\d*) a decimal number followed by
    // \/? optionally a / followed by
    // (edit)? optionally the text edit
    // all surrounded by /regExpressionHere/

    // this regular expression catches /users/10
    // or /users/10/
    // or /users/10/edit

    var message = "user " + req.params[0] + " profile";

    if(req.params[1] === 'edit') {
        message = "Editing " + message;
    } else {
        message = "Viewing " + message;
    }

    res.send(message);
});

http.createServer(app).listen(app.get('port'), function(){
   console.log("Express server listening on port " + app.get('port'));
});