// SPDX-FileCopyrightText: Copyright © 2026 Caleb Cushing
//
// SPDX-License-Identifier: MIT

package com.xenoterracide.ghsecrets;

import picocli.CommandLine;

@CommandLine.Command(
    name = "push",
    description = "Push secrets to GitHub Actions across repos selected by topic.",
    mixinStandardHelpOptions = true
)
public final class PushCommand implements Runnable {

  @CommandLine.Option(names = "--topic", description = "GitHub repo topic used to select repositories.")
  String topic;

  @CommandLine.Option(names = "--org", description = "GitHub org or username.")
  String org;

  @CommandLine.Option(names = "--env", description = "Path to env file containing secrets.")
  String env;

  @CommandLine.Option(names = "--keyid", description = "GPG key id / fingerprint to export.")
  String keyId;

  @CommandLine.Option(names = "--dry-run", description = "Do not call gh secret set; print intended operations.")
  boolean dryRun;

  @CommandLine.Option(names = "--debug", description = "Enable verbose logging with redaction.")
  boolean debug;

  @Override
  public void run() {
    // TODO: implement per spec.
    throw new CommandLine.ParameterException(new CommandLine(this), "Not implemented yet.");
  }
}
