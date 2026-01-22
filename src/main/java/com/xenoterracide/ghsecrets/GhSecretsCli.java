// SPDX-FileCopyrightText: Copyright © 2026 Caleb Cushing
//
// SPDX-License-Identifier: MIT

package com.xenoterracide.ghsecrets;

import picocli.CommandLine;

@CommandLine.Command(
    name = "gh-secrets",
    mixinStandardHelpOptions = true,
    subcommands = {
      PushCommand.class,
    }
)
public final class GhSecretsCli implements Runnable {

  public static void main(String[] args) {
    int exitCode = new CommandLine(new GhSecretsCli()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public void run() {
    throw new CommandLine.ParameterException(new CommandLine(this), "Missing required command.");
  }
}
