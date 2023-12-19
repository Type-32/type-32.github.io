job("Qodana") {
  startOn {
    gitPush {
      anyBranchMatching {
        +"main"
      }
    }
    codeReviewOpened{}
  }
  container("jetbrains/qodana-js") {
    env["QODANA_TOKEN"] = "{{ project:qodana-token }}"
    shellScript {
      content = "qodana --baseline qodana.sarif.json"
    }
  }
}