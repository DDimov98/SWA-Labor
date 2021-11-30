/*========================================================================*
 *                                                                        *
 * This software is governed by the GPL version 2.                        *
 *                                                                        *
 * Copyright: Joerg Friedrich, University of Applied Sciences Esslingen   *
 *                                                                        *
 * $Id:$
 *                                                                        *
 *========================================================================*/
package de.hse.swa.jodel.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the VOTING database table.
 * 
 */
@Entity
@Table(name = "Voting")
public class Voting {
	
    @Id
    @SequenceGenerator(name = "voteSeq", sequenceName = "ZSEQ_VOTE_ID", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "voteSeq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "commentId")
	private Long commentId;

	@Column(name = "authorId")
	private Long authorId;

	@Column(name = "value")
	private int value;

	public Voting() {
	}
	

}