package com.company.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class NextSequenceService {
	
	@Autowired
    private MongoOperations mongoOperations;

    public Long getNextSequence(String seqName) {
        CustomSequence sequence = mongoOperations.findAndModify(
            new Query(where("_id").is(seqName)),
            new Update().inc("seq", 1),
            FindAndModifyOptions.options().returnNew(true).upsert(true),
            CustomSequence.class // Reference to the new CustomSequence class
        );

        // Return the sequence, or 1L if it's not found
        return sequence != null ? sequence.getSeq() : 1L;
    }

}
