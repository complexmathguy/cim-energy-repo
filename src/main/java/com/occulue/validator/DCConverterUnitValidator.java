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
package com.occulue.validator;

import org.springframework.util.Assert;

import com.occulue.api.*;

public class DCConverterUnitValidator {

  /** default constructor */
  protected DCConverterUnitValidator() {}

  /** factory method */
  public static DCConverterUnitValidator getInstance() {
    return new DCConverterUnitValidator();
  }

  /** handles creation validation for a DCConverterUnit */
  public void validate(CreateDCConverterUnitCommand dCConverterUnit) throws Exception {
    Assert.notNull(dCConverterUnit, "CreateDCConverterUnitCommand should not be null");
    //		Assert.isNull( dCConverterUnit.getDCConverterUnitId(), "CreateDCConverterUnitCommand
    // identifier should be null" );
  }

  /** handles update validation for a DCConverterUnit */
  public void validate(UpdateDCConverterUnitCommand dCConverterUnit) throws Exception {
    Assert.notNull(dCConverterUnit, "UpdateDCConverterUnitCommand should not be null");
    Assert.notNull(
        dCConverterUnit.getDCConverterUnitId(),
        "UpdateDCConverterUnitCommand identifier should not be null");
  }

  /** handles delete validation for a DCConverterUnit */
  public void validate(DeleteDCConverterUnitCommand dCConverterUnit) throws Exception {
    Assert.notNull(dCConverterUnit, "{commandAlias} should not be null");
    Assert.notNull(
        dCConverterUnit.getDCConverterUnitId(),
        "DeleteDCConverterUnitCommand identifier should not be null");
  }

  /** handles fetchOne validation for a DCConverterUnit */
  public void validate(DCConverterUnitFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "DCConverterUnitFetchOneSummary should not be null");
    Assert.notNull(
        summary.getDCConverterUnitId(),
        "DCConverterUnitFetchOneSummary identifier should not be null");
  }
}
