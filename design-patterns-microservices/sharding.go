package design_patterns_microservices

import (
	"crypto/sha1"
	"sync"
)

type Shard struct {
	sync.RWMutex
	shardMap map[string]interface{}
}

type ShardedMap []*Shard

func NewShardedMap(shardsNum int) ShardedMap {
	shards := make([]*Shard, shardsNum)

	for i := 0; i < shardsNum; i++ {
		newShardMap := make(map[string]interface{})
		shards[i] = &Shard{shardMap: newShardMap}
	}

	return shards
}

func (shardedMap ShardedMap) getShardIndex(key string) int {
	checksum := sha1.Sum([]byte(key))
	hash := int(checksum[17])
	return hash % len(shardedMap)
}

func (shardedMap ShardedMap) getShard(key string) *Shard {
	index := shardedMap.getShardIndex(key)
	return shardedMap[index]
}

func (shardedMap ShardedMap) Delete(key string) {
	shard := shardedMap.getShard(key)

	shard.Lock()
	defer shard.Unlock()

	delete(shard.shardMap, key)
}
