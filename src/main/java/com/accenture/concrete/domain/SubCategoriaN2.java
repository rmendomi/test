package com.accenture.concrete.domain;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class SubCategoriaN2 implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    String id;

    String name;

    int relevance;

    String iconImageUrl;
    
    List<SubCategoriaN3> subcategories;

	public Object startsWith(List<SubCategoriaN2> rest) {
		// TODO Auto-generated method stub
		return null;
	}

}
