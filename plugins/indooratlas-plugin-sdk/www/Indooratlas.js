var IndoorAtlas = {};

/**
 * Check if IndoorAtlas is currently connected
 * @param  {Function} cb function(error, connected)
 */
IndoorAtlas.createIALocationManager = function(cb){
    cordova.exec(function(result){ cb(null, result); }, function(result){ cb(null, result);}, 'IndoorAtlas', 'createIALocationManager', []);
    console.log("finished over here");
};

/**
 * Get information about firmware installed on IndoorAtlas
 * @param  {Function} cb function(error, info)
 */
IndoorAtlas.getWatchFWVersion = function(cb){
    cordova.exec(function(result){ cb(null, result); }, cb, 'IndoorAtlas', 'getWatchFWVersion', []);
};



module.exports = IndoorAtlas;