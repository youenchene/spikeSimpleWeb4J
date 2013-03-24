Spike SimpleWeb4J
================

Spike based on  :
 - angular.js
 - Twitter Bootstrap
 - SimpleWeb 4J (Yan Bonnel young light web framework).
 - Morphia (lightweight OIRM for Mongo)

Demo 
====

http://spikesimpleweb4j.ys276.cloudbees.net/

Deployment 
===========

bees app:deploy -a  spikeSimpleWeb4J  -t java   -R class=ychene.spike.SpikeSimpleWeb4JController   -R classpath=spikeSimpleWeb4J/*  -Rjava_version=1.7 spikeSimpleWeb4J-cloudbees.zip waitForApplicationStart=false  

