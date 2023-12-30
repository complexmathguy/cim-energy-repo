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

public class TerminalValidator {

  /** default constructor */
  protected TerminalValidator() {}

  /** factory method */
  public static TerminalValidator getInstance() {
    return new TerminalValidator();
  }

  /** handles creation validation for a Terminal */
  public void validate(CreateTerminalCommand terminal) throws Exception {
    Assert.notNull(terminal, "CreateTerminalCommand should not be null");
    //		Assert.isNull( terminal.getTerminalId(), "CreateTerminalCommand identifier should be null"
    // );
  }

  /** handles update validation for a Terminal */
  public void validate(UpdateTerminalCommand terminal) throws Exception {
    Assert.notNull(terminal, "UpdateTerminalCommand should not be null");
    Assert.notNull(terminal.getTerminalId(), "UpdateTerminalCommand identifier should not be null");
  }

  /** handles delete validation for a Terminal */
  public void validate(DeleteTerminalCommand terminal) throws Exception {
    Assert.notNull(terminal, "{commandAlias} should not be null");
    Assert.notNull(terminal.getTerminalId(), "DeleteTerminalCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Terminal */
  public void validate(TerminalFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "TerminalFetchOneSummary should not be null");
    Assert.notNull(
        summary.getTerminalId(), "TerminalFetchOneSummary identifier should not be null");
  }
}
