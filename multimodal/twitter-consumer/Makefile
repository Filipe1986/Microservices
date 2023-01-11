image:
	mvn clean verify -Pprod jib:dockerBuild

compile:
	mvn clean compile -Pprod jib:dockerBuild

app:
	docker-compose -f src/main/docker/app.yml up

down:
	docker-compose -f src/main/docker/app.yml down