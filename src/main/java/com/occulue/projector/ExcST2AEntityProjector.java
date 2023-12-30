/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.projector;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.repository.*;

/**
 * Projector for ExcST2A as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by ExcST2AAggregate
 *
 * @author your_name_here
 */
@Component("excST2A-entity-projector")
public class ExcST2AEntityProjector {

  // core constructor
  public ExcST2AEntityProjector(ExcST2ARepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a ExcST2A
   *
   * @param	entity ExcST2A
   */
  public ExcST2A create(ExcST2A entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a ExcST2A
   *
   * @param	entity ExcST2A
   */
  public ExcST2A update(ExcST2A entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a ExcST2A
   *
   * @param	id		UUID
   */
  public ExcST2A delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    ExcST2A entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /*
   * Assign a Efdmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignEfdmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Efdmax as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Efdmax to the parent entity
    // ------------------------------------------
    parentEntity.setEfdmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Efdmax
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignEfdmax(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Efdmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Efdmax on the parent entithy
    // ------------------------------------------
    parentEntity.setEfdmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ka
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignKa(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ka as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ka to the parent entity
    // ------------------------------------------
    parentEntity.setKa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ka
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignKa(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ka on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ka on the parent entithy
    // ------------------------------------------
    parentEntity.setKa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kc
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignKc(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kc as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kc to the parent entity
    // ------------------------------------------
    parentEntity.setKc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kc
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignKc(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kc on the parent entithy
    // ------------------------------------------
    parentEntity.setKc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ke
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignKe(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ke as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ke to the parent entity
    // ------------------------------------------
    parentEntity.setKe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ke
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignKe(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ke on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ke on the parent entithy
    // ------------------------------------------
    parentEntity.setKe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kf
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignKf(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kf as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kf to the parent entity
    // ------------------------------------------
    parentEntity.setKf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kf
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignKf(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kf on the parent entithy
    // ------------------------------------------
    parentEntity.setKf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ki
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignKi(UUID parentId, PU assignment) {
    LOGGER.info("assigning Ki as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Ki to the parent entity
    // ------------------------------------------
    parentEntity.setKi(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ki
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignKi(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ki on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ki on the parent entithy
    // ------------------------------------------
    parentEntity.setKi(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Kp
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignKp(UUID parentId, PU assignment) {
    LOGGER.info("assigning Kp as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Kp to the parent entity
    // ------------------------------------------
    parentEntity.setKp(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Kp
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignKp(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Kp on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Kp on the parent entithy
    // ------------------------------------------
    parentEntity.setKp(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Ta
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST2A
   */
  public ExcST2A assignTa(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Ta as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Ta to the parent entity
    // ------------------------------------------
    parentEntity.setTa(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Ta
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignTa(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Ta on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Ta on the parent entithy
    // ------------------------------------------
    parentEntity.setTa(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tb
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST2A
   */
  public ExcST2A assignTb(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tb as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tb to the parent entity
    // ------------------------------------------
    parentEntity.setTb(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tb
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignTb(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tb on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tb on the parent entithy
    // ------------------------------------------
    parentEntity.setTb(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tc
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST2A
   */
  public ExcST2A assignTc(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tc as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tc to the parent entity
    // ------------------------------------------
    parentEntity.setTc(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tc
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignTc(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tc on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tc on the parent entithy
    // ------------------------------------------
    parentEntity.setTc(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Te
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST2A
   */
  public ExcST2A assignTe(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Te as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Te to the parent entity
    // ------------------------------------------
    parentEntity.setTe(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Te
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignTe(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Te on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Te on the parent entithy
    // ------------------------------------------
    parentEntity.setTe(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Tf
   *
   * @param	parentId	UUID
   * @param	assignment 	Seconds
   * @return	ExcST2A
   */
  public ExcST2A assignTf(UUID parentId, Seconds assignment) {
    LOGGER.info("assigning Tf as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = SecondsProjector.find(assignment.getSecondsId());

    // ------------------------------------------
    // assign the Tf to the parent entity
    // ------------------------------------------
    parentEntity.setTf(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Tf
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignTf(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Tf on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Tf on the parent entithy
    // ------------------------------------------
    parentEntity.setTf(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Uelin
   *
   * @param	parentId	UUID
   * @param	assignment 	BooleanProxy
   * @return	ExcST2A
   */
  public ExcST2A assignUelin(UUID parentId, BooleanProxy assignment) {
    LOGGER.info("assigning Uelin as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = BooleanProxyProjector.find(assignment.getBooleanProxyId());

    // ------------------------------------------
    // assign the Uelin to the parent entity
    // ------------------------------------------
    parentEntity.setUelin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Uelin
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignUelin(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Uelin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Uelin on the parent entithy
    // ------------------------------------------
    parentEntity.setUelin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmax
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignVrmax(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmax as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmax to the parent entity
    // ------------------------------------------
    parentEntity.setVrmax(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmax
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignVrmax(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmax on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmax on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmax(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Assign a Vrmin
   *
   * @param	parentId	UUID
   * @param	assignment 	PU
   * @return	ExcST2A
   */
  public ExcST2A assignVrmin(UUID parentId, PU assignment) {
    LOGGER.info("assigning Vrmin as " + assignment.toString());

    ExcST2A parentEntity = repository.findById(parentId).get();
    assignment = PUProjector.find(assignment.getPUId());

    // ------------------------------------------
    // assign the Vrmin to the parent entity
    // ------------------------------------------
    parentEntity.setVrmin(assignment);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /*
   * Unassign the Vrmin
   *
   * @param	parentId		UUID
   * @return	ExcST2A
   */
  public ExcST2A unAssignVrmin(UUID parentId) {
    ExcST2A parentEntity = repository.findById(parentId).get();

    LOGGER.info("unAssigning Vrmin on " + parentEntity.toString());

    // ------------------------------------------
    // null out the Vrmin on the parent entithy
    // ------------------------------------------
    parentEntity.setVrmin(null);

    // ------------------------------------------
    // save the parent entity
    // ------------------------------------------
    repository.save(parentEntity);

    return parentEntity;
  }

  /**
   * Method to retrieve the ExcST2A via an FindExcST2AQuery
   *
   * @return query FindExcST2AQuery
   */
  @SuppressWarnings("unused")
  public ExcST2A find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a ExcST2A - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all ExcST2As
   *
   * @param query FindAllExcST2AQuery
   * @return List<ExcST2A>
   */
  @SuppressWarnings("unused")
  public List<ExcST2A> findAll(FindAllExcST2AQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all ExcST2A - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final ExcST2ARepository repository;

  @Autowired
  @Qualifier(value = "pU-entity-projector")
  PUEntityProjector PUProjector;

  @Autowired
  @Qualifier(value = "seconds-entity-projector")
  SecondsEntityProjector SecondsProjector;

  @Autowired
  @Qualifier(value = "booleanProxy-entity-projector")
  BooleanProxyEntityProjector BooleanProxyProjector;

  private static final Logger LOGGER = Logger.getLogger(ExcST2AEntityProjector.class.getName());
}
