#!/bin/bash
SERVER_HOME=$(dirname $0)
java -cp "$SERVER_HOME/lib/*:$SERVER_HOME/config/" atm.business.server.Server