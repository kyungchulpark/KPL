const express = require('express'),
      app = express(),
      bodyParser = require('body-parser');

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({extended: false}));

// parse application/json
app.use(bodyParser.json());

// Add headers
app.use(function (req, res, next) {

  // Website you wish to allow to connect
  res.setHeader('Access-Control-Allow-Origin', 'http://localhost:8099');

  // Request methods you wish to allow
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');

  // Request headers you wish to allow
  res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');

  // Set to true if you need the website to include cookies in the requests sent
  // to the API (e.g. in case you use sessions)
  // res.setHeader('Access-Control-Allow-Credentials', true);

  // Pass to next layer of middleware
  next();
});

/**
 *  TWITTER ENDPOINT
 */
app.get('/tweets_last/:limit', function (req, res) {
  const Twitter = require('twitter');

  const client = new Twitter({
    consumer_key: 'YOUR_CONSUMER_KEY',
    consumer_secret: 'YOUR_CONSUMER_SECRET',
    access_token_key: 'YOUR_ACCESS_TOKEN_KEY',
    access_token_secret: 'YOUR_ACCESS_TOKEN_SECRET'
  });

  const params = {
    count: req.params.limit
  };

  client.get('statuses/user_timeline', params, function(error, tweets, response) {
    if(error) throw error;
    res.send(tweets);
  });
});

app.listen(3003);
console.log('Pixel Diamond Server: Listening on port 3003...');