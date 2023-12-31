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
 * Projector for RegulatingControl as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by RegulatingControlAggregate
 *
 * @author your_name_here
 */
@Component("regulatingControl-entity-projector")
public class RegulatingControlEntityProjector {

  // core constructor
  public RegulatingControlEntityProjector(RegulatingControlRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a RegulatingControl
   *
   * @param	entity RegulatingControl
   */
  public RegulatingControl create(RegulatingControl entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a RegulatingControl
   *
   * @param	entity RegulatingControl
   */
  public RegulatingControl update(RegulatingControl entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a RegulatingControl
   *
   * @param	id		UUID
   */
  public RegulatingControl delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    RegulatingControl entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the RegulatingControl via an FindRegulatingControlQuery
   *
   * @return query FindRegulatingControlQuery
   */
  @SuppressWarnings("unused")
  public RegulatingControl find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a RegulatingControl - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all RegulatingControls
   *
   * @param query FindAllRegulatingControlQuery
   * @return List<RegulatingControl>
   */
  @SuppressWarnings("unused")
  public List<RegulatingControl> findAll(FindAllRegulatingControlQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all RegulatingControl - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final RegulatingControlRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(RegulatingControlEntityProjector.class.getName());
}
