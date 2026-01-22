// SPDX-FileCopyrightText: Copyright © 2026 Caleb Cushing
//
// SPDX-License-Identifier: MIT

package com.xenoterracide.ghsecrets;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.*;

final class GhSecretsCliTest {

  @Test
  void helpWorks() {
    CommandLine cmd = new CommandLine(new GhSecretsCli());
    assertEquals(0, cmd.execute("--help"));
  }
}
