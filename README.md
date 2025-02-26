# hpademo

powershell

minikube start

minikube docker-env | Invoke-Expression

docker build -t hpa-demo:latest .

kubectl apply -f deployment.yaml

kubectl apply -f service.yaml

kubectl apply -f hpa.yaml

kubectl get hpa

kubectl port-forward svc/hpa-demo-service 8080:80

while ($true) { Invoke-WebRequest -Uri "http://localhost:8080/load/cpu" -UseBasicParsing; Start-Sleep -Milliseconds 500 }
