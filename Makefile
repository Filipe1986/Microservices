docker-up:
	docker-compose -f docker/common.yml -f docker/kafka_cluster.yml up