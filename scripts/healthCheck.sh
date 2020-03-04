#!/bin/bash
echo "> Start Health check"
echo "> curl -s http://localhost:8080/actuator/health "

for RETRY_COUNT in {1..15}
do
  RESPONSE=$(curl -s http://localhost:8080/actuator/health)
  UP_COUNT=$(echo $RESPONSE | grep 'UP' | wc -l)

  if [ $UP_COUNT -ge 1 ]
  then
      echo "> Health check success"
      break
  else
      echo "> Unhealthy."
      echo "> Health check: ${RESPONSE}"
  fi

  if [ $RETRY_COUNT -eq 10 ]
  then
    echo "> Health check failed. "
    exit 1
  fi

  echo "> Health check connection failed. Retry..."
  sleep 10
done
exit 0