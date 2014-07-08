/*
 * Copyright COCKTAIL (www.cocktail.org), 1995, 2009 This software 
 * is governed by the CeCILL license under French law and abiding by the
 * rules of distribution of free software. You can use, modify and/or 
 * redistribute the software under the terms of the CeCILL license as 
 * circulated by CEA, CNRS and INRIA at the following URL 
 * "http://www.cecill.info". 
 * As a counterpart to the access to the source code and rights to copy, modify 
 * and redistribute granted by the license, users are provided only with a 
 * limited warranty and the software's author, the holder of the economic 
 * rights, and the successive licensors have only limited liability. In this 
 * respect, the user's attention is drawn to the risks associated with loading,
 * using, modifying and/or developing or reproducing the software by the user 
 * in light of its specific status of free software, that may mean that it
 * is complicated to manipulate, and that also therefore means that it is 
 * reserved for developers and experienced professionals having in-depth
 * computer knowledge. Users are therefore encouraged to load and test the 
 * software's suitability as regards their requirements in conditions enabling
 * the security of their systems and/or data to be ensured and, more generally, 
 * to use and operate it in the same conditions as regards security. The
 * fact that you are presently reading this means that you have had knowledge 
 * of the CeCILL license and that you accept its terms.
 */

// DO NOT EDIT.  Make changes to ${entity.classNameWithOptionalPackage}.java instead.
#if ($entity.superclassPackageName)
package $entity.superclassPackageName;

#end
import com.webobjects.foundation.*;
import com.webobjects.eocontrol.*;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.NoSuchElementException;

import org.cocktail.fwkcktlpersonne.server.eospecificites.ISpecificite;


public abstract class ${entity.prefixClassNameWithoutPackage} extends #if ($entity.partialEntitySet)er.extensions.partials.ERXPartial<${entity.partialEntity.className}>#elseif ($entity.parentSet)${entity.parent.classNameWithDefault}#elseif ($EOGenericRecord)${EOGenericRecord}#else AfwkPersRecord#end {
#if ($entity.partialEntitySet)
	public static final String ENTITY_NAME = "$entity.partialEntity.name";
#else
	public static final String ENTITY_NAME = "$entity.name";
#end
#if ($entity.externalName)
	public static final String ENTITY_TABLE_NAME = "$entity.externalName";
#end



	// Attributes

#set( $pkCount = $entity.primaryKeyAttributes.size() )  
#if ($pkCount == 1)
	public static final String ENTITY_PRIMARY_KEY = "$entity.singlePrimaryKeyAttribute.name";
#end	

#foreach ($attribute in $entity.sortedClassAttributes)
	public static final String ${attribute.uppercaseUnderscoreName}_KEY = "$attribute.name";
#end

// Attributs non visibles
#foreach ($attribute in $entity.nonClassAttributes)
	public static final String ${attribute.uppercaseUnderscoreName}_KEY = "$attribute.name";
#end

//Colonnes dans la base de donnees
#foreach ($attribute in $entity.sortedClassAttributes)
	public static final String ${attribute.uppercaseUnderscoreName}_COLKEY = "$attribute.columnName";
#end

#foreach ($attribute in $entity.nonClassAttributes)
	public static final String ${attribute.uppercaseUnderscoreName}_COLKEY = "$attribute.columnName";
#end


	// Relationships
#foreach ($relationship in $entity.sortedClassRelationships)
	public static final String ${relationship.uppercaseUnderscoreName}_KEY = "$relationship.name";
#end



	// Accessors methods
#foreach ($attribute in $entity.sortedClassAttributes)
#if (!$attribute.inherited)
#if ($attribute.userInfo.ERXConstantClassName)
  public $attribute.userInfo.ERXConstantClassName ${attribute.name}() {
    Number value = (Number)storedValueForKey(${attribute.uppercaseUnderscoreName}_KEY);
    return ($attribute.userInfo.ERXConstantClassName)value;
  }

  public void set${attribute.capitalizedName}($attribute.userInfo.ERXConstantClassName value) {
    takeStoredValueForKey(value, ${attribute.uppercaseUnderscoreName}_KEY);
  }
#else
  public $attribute.javaClassName ${attribute.name}() {
    return ($attribute.javaClassName) storedValueForKey(${attribute.uppercaseUnderscoreName}_KEY);
  }

  public void set${attribute.capitalizedName}($attribute.javaClassName value) {
    takeStoredValueForKey(value, ${attribute.uppercaseUnderscoreName}_KEY);
  }
#end

#end
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
#if (!$relationship.inherited) 
  public $relationship.actualDestination.classNameWithDefault ${relationship.name}() {
    return ($relationship.actualDestination.classNameWithDefault)storedValueForKey(${relationship.uppercaseUnderscoreName}_KEY);
  }

  public void set${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault value) {
    if (value == null) {
    	$relationship.actualDestination.classNameWithDefault oldValue = ${relationship.name}();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, ${relationship.uppercaseUnderscoreName}_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, ${relationship.uppercaseUnderscoreName}_KEY);
    }
  }
  
#end
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
#if (!$relationship.inherited) 
  public NSArray ${relationship.name}() {
    return (NSArray)storedValueForKey(${relationship.uppercaseUnderscoreName}_KEY);
  }

#if (!$relationship.inverseRelationship || $relationship.flattened || !$relationship.inverseRelationship.classProperty)
  public NSArray ${relationship.name}(EOQualifier qualifier) {
    return ${relationship.name}(qualifier, null);
  }
#else
  public NSArray ${relationship.name}(EOQualifier qualifier) {
    return ${relationship.name}(qualifier, null, false);
  }

  public NSArray ${relationship.name}(EOQualifier qualifier, boolean fetch) {
    return ${relationship.name}(qualifier, null, fetch);
  }
#end

  public NSArray ${relationship.name}(EOQualifier qualifier, NSArray sortOrderings#if ($relationship.inverseRelationship && !$relationship.flattened && $relationship.inverseRelationship.classProperty), boolean fetch#end) {
    NSArray results;
#if ($relationship.inverseRelationship && !$relationship.flattened && $relationship.inverseRelationship.classProperty)
    if (fetch) {
      EOQualifier fullQualifier;
#if (${relationship.actualDestination.genericRecord})
      EOQualifier inverseQualifier = new EOKeyValueQualifier("${relationship.inverseRelationship.name}", EOQualifier.QualifierOperatorEqual, this);
#else
      EOQualifier inverseQualifier = new EOKeyValueQualifier(${relationship.actualDestination.classNameWithDefault}.${relationship.inverseRelationship.uppercaseUnderscoreName}_KEY, EOQualifier.QualifierOperatorEqual, this);
#end
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

#if (${relationship.actualDestination.genericRecord})
      EOFetchSpecification fetchSpec = new EOFetchSpecification("${relationship.actualDestination.name}", qualifier, sortOrderings);
      fetchSpec.setIsDeep(true);
      results = (NSArray)editingContext().objectsWithFetchSpecification(fetchSpec);
#else
      results = ${relationship.actualDestination.classNameWithDefault}.fetchAll(editingContext(), fullQualifier, sortOrderings);
#end
    }
    else {
#end
      results = ${relationship.name}();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
#if ($relationship.inverseRelationship && !$relationship.flattened && $relationship.inverseRelationship.classProperty)
    }
#end
    return results;
  }
  
  public void addTo${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
    addObjectToBothSidesOfRelationshipWithKey(object, ${relationship.uppercaseUnderscoreName}_KEY);
  }

  public void removeFrom${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, ${relationship.uppercaseUnderscoreName}_KEY);
  }

  public $relationship.actualDestination.classNameWithDefault create${relationship.capitalizedName}Relationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("${relationship.actualDestination.name}");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, ${relationship.uppercaseUnderscoreName}_KEY);
    return ($relationship.actualDestination.classNameWithDefault) eo;
  }

  public void delete${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, ${relationship.uppercaseUnderscoreName}_KEY);
#if (!$relationship.ownsDestination)
    editingContext().deleteObject(object);
#end
  }

  public void deleteAll${relationship.capitalizedName}Relationships() {
    Enumeration objects = ${relationship.name}().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      delete${relationship.capitalizedName}Relationship(($relationship.actualDestination.classNameWithDefault)objects.nextElement());
    }
  }

#end
#end

/**
 * Créer une instance de $entity.classNameWithOptionalPackage avec les champs et relations obligatoires et l'insere dans l'editingContext.
 */
  public #if (!$entity.partialEntitySet)static #end ${entity.classNameWithOptionalPackage}#if (!$entity.partialEntitySet) create#else init#end${entity.classNameWithOptionalPackage}(EOEditingContext editingContext#foreach ($attribute in $entity.sortedClassAttributes)
#if (!$attribute.allowsNull)
#set ($restrictingQualifierKey = 'false')
#foreach ($qualifierKey in $entity.restrictingQualifierKeys)#if ($attribute.name == $qualifierKey)#set ($restrictingQualifierKey = 'true')#end#end
#if ($restrictingQualifierKey == 'false')
#if ($attribute.userInfo.ERXConstantClassName), ${attribute.userInfo.ERXConstantClassName}#else, ${attribute.javaClassName}#end ${attribute.name}
#end
#end
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
#if ($relationship.mandatory && !($relationship.ownsDestination && $relationship.propagatesPrimaryKey)), ${relationship.actualDestination.classNameWithDefault} ${relationship.name}#end
#end
			) {
    ${entity.classNameWithOptionalPackage} eo = (${entity.classNameWithOptionalPackage})#if ($entity.partialEntitySet)this;#else createAndInsertInstance(editingContext, ${entity.prefixClassNameWithoutPackage}.ENTITY_NAME);#end
    
#foreach ($attribute in $entity.sortedClassAttributes)
#if (!$attribute.allowsNull)
#set ($restrictingQualifierKey = 'false')
#foreach ($qualifierKey in $entity.restrictingQualifierKeys) 
#if ($attribute.name == $qualifierKey)
#set ($restrictingQualifierKey = 'true')
#end
#end
#if ($restrictingQualifierKey == 'false')
		eo.set${attribute.capitalizedName}(${attribute.name});
#end
#end
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
#if ($relationship.mandatory && !($relationship.ownsDestination && $relationship.propagatesPrimaryKey))
    eo.set${relationship.capitalizedName}Relationship(${relationship.name});
#end
#end
    return eo;
  }
#if (!$entity.partialEntitySet)

  
#if (!$entity.partialEntitySet)
	  public $entity.classNameWithOptionalPackage localInstanceIn(EOEditingContext editingContext) {
	  		return (${entity.classNameWithOptionalPackage})localInstanceOfObject(editingContext, this);
	  }
#end  
	
#if (!$entity.partialEntitySet)

	/**
	 * Cree une instance de l'objet et l'insere dans l'editing context. Cette methode n'iformera pas les objets de type ISpecificite.
	 * @param editingContext
	 * 
	 * @return L'objet insere dans l'editing context.
	 */
	  public static $entity.classNameWithOptionalPackage creerInstance(EOEditingContext editingContext) {
	  		return creerInstance(editingContext, null);
		}

	/**
	 * Cree une instance de l'objet et l'insere dans l'editing context.
	 * @param editingContext
	 * @param specificites Un tableau d'objets {@link ISpecificite}. Ce tableau sera affecte a l'objet. Les objets en question seront notifies de la creation de l'objet metier.
	 * @return L'objet insere dans l'editing context.
	 */
	  public static $entity.classNameWithOptionalPackage creerInstance(EOEditingContext editingContext, NSArray specificites) {
	  		$entity.classNameWithOptionalPackage object = ($entity.classNameWithOptionalPackage)createAndInsertInstance(editingContext, ${entity.prefixClassNameWithoutPackage}.ENTITY_NAME, specificites);
	  		return object;
		}
#end  
	
	
  
  public static ${entity.classNameWithOptionalPackage} localInstanceIn(EOEditingContext editingContext, ${entity.classNameWithOptionalPackage} eo) {
    ${entity.classNameWithOptionalPackage} localInstance = (eo == null) ? null : (${entity.classNameWithOptionalPackage})localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  /**
   * 
   * @param editingContext
   * @param eo
   * @return L'objet eo dans l'editingContext
   * @deprecated Utilisez $entity.classNameWithOptionalPackage#localInstanceIn a la place.
   */
	public static ${entity.classNameWithOptionalPackage} localInstanceOf(EOEditingContext editingContext, $entity.classNameWithOptionalPackage eo) {
		return ${entity.classNameWithOptionalPackage}.localInstanceIn(editingContext, eo);
	}
  
	
	
	
	
	
	
	/* Finders */

	  public static NSArray fetchAll(EOEditingContext editingContext) {
	    return fetchAll(editingContext, (EOQualifier)null);
	  }

	  public static NSArray fetchAll(EOEditingContext editingContext, NSArray sortOrderings) {
	    return fetchAll(editingContext, null, sortOrderings);
	  }
	  
	  public static NSArray fetchAll(EOEditingContext editingContext, EOQualifier qualifier) {
		  return fetchAll(editingContext, qualifier, null, false);
	  }

	  public static NSArray fetchAll(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
		return fetchAll(editingContext, qualifier, sortOrderings, false);
	  }

	  public static NSArray fetchAll(EOEditingContext editingContext, String keyName, Object value, NSArray sortOrderings) {
		return fetchAll(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings, false);
	  }
	  
	  public static NSArray fetchAll(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings, boolean distinct) {
	    EOFetchSpecification fetchSpec = new EOFetchSpecification(ENTITY_NAME, qualifier, sortOrderings);
	    fetchSpec.setIsDeep(true);
	    fetchSpec.setUsesDistinct(distinct);
	    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
	    return eoObjects;
	  }

		/**
		* Renvoie un objet simple. Pour recuperer un tableau, utilisez fetchAll(EOEditingContext editingContext, String keyName, Object value, NSArray sortOrderings).
		* Une exception est declenchee si plusieurs objets sont trouves.
		* 
		* @return Renvoie l'objet correspondant a la paire cle/valeur
		* @throws IllegalStateException  
		*/
	  public static ${entity.classNameWithOptionalPackage} fetchByKeyValue(EOEditingContext editingContext, String keyName, Object value) {
	    return fetchByQualifier(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	  }

	  
	  /**
	   * Renvoie l'objet correspondant au qualifier. Si plusieurs objets sont susceptibles d'etre trouves, utilisez fetchFirstByQualifier().
	   * Une exception est declenchee si plusieurs objets sont trouves.
	   * 
	 * @param editingContext
	 * @param qualifier
	 * @return L'objet qui correspond au qualifier passé en parametre. Si plusieurs objets sont trouve, une Exception est declenchee. Si aucun objet est trouve, null est renvoye.
	 * @throws IllegalStateException
	 */
	public static ${entity.classNameWithOptionalPackage} fetchByQualifier(EOEditingContext editingContext, EOQualifier qualifier) {
	    NSArray eoObjects = fetchAll(editingContext, qualifier, null);
	    ${entity.classNameWithOptionalPackage} eoObject;
	    int count = eoObjects.count();
	    if (count == 0) {
	      eoObject = null;
	    }
	    else if (count == 1) {
	      eoObject = (${entity.classNameWithOptionalPackage})eoObjects.objectAtIndex(0);
	    }
	    else {
	      throw new IllegalStateException("Il y a plus d'un objet qui correspond au qualifier '" + qualifier + "'.");
	    }
	    return eoObject;
	  }

	  
	  
	  
	  public static ${entity.classNameWithOptionalPackage} fetchFirstByQualifier(EOEditingContext editingContext, EOQualifier qualifier) {
	   	 return fetchFirstByQualifier(editingContext, qualifier, null);
	  }
	  
	  public static ${entity.classNameWithOptionalPackage} fetchFirstByQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
	    NSArray eoObjects = fetchAll(editingContext, qualifier, sortOrderings);
	    ${entity.classNameWithOptionalPackage} eoObject;
	    int count = eoObjects.count();
	    if (count == 0) {
	      eoObject = null;
	    }
	    else {
	      eoObject = (${entity.classNameWithOptionalPackage})eoObjects.objectAtIndex(0);
	    }
	    return eoObject;
	  }  

	  
	  /**
	   * Une exception est declenchee si aucun objet est trouve.
	   * 
	   * @param editingContext
	   * @param qualifier Le filtre
	   * @return L'objet correspondant au qualifier. Si l'objet n'est pas trouvé, une exception est declenchee. Pour ne pas avoir d'exception, utilisez fetchFirstByQualifier().
	   * @throws NoSuchElementException si aucun objet est trouve
	   */
	  public static ${entity.classNameWithOptionalPackage} fetchFirstRequiredByQualifier(EOEditingContext editingContext, EOQualifier qualifier) {
		  ${entity.classNameWithOptionalPackage} eoObject = fetchFirstByQualifier(editingContext, qualifier);
	    if (eoObject == null) {
	      throw new NoSuchElementException("Aucun objet ${entity.classNameWithOptionalPackage} ne correspond au qualifier '" + qualifier + "'.");
	    }
	    return eoObject;
	  }	
	

	public static ${entity.classNameWithOptionalPackage} fetchRequiredByKeyValue(EOEditingContext editingContext, String keyName, Object value) {
		    return fetchFirstRequiredByQualifier(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}
	  	
	
	
	
  
#end
}
