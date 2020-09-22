'use strict';

let path = require('path');
const UglifyJsPlugin = require('uglifyjs-webpack-plugin');


module.exports = {
    mode: 'development',
    entry: './app/index.js',
    output: {
        filename: 'bundle.js',
        path: __dirname + '/dist/js'
    },
    watch: true,

    devtool: 'source-map', // Enable source maps. Please note that this will slow down the build

    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader?optional[]=runtime',
                    options: {
                        presets: [
                            ["@babel/env", {
                                targets: {
                                    edge: "17",
                                    firefox: "60",
                                    chrome: "67",
                                    safari: "11.1",
                                    ie: "11"
                                },
                                useBuiltIns: "usage"
                            }],
                            "@babel/preset-react"
                        ]
                    }
                }
            }
        ]
    },
    plugins: [
        new UglifyJsPlugin()
    ]
};
